package com.bwheeler8715.wordsearch.generator;

import com.bwheeler8715.wordsearch.WordSearch;
import com.bwheeler8715.wordsearch.configuration.Configuration;
import com.bwheeler8715.wordsearch.configuration.WordDirectionEnum;
import com.bwheeler8715.wordsearch.exception.WordSearchGenerationFailureException;
import com.bwheeler8715.wordsearch.generator.grid.Coordinate;
import com.bwheeler8715.wordsearch.generator.grid.Grid;
import com.bwheeler8715.wordsearch.word.WordValidator;
import com.bwheeler8715.wordsearch.word.WordValidatorSingleton;

import java.util.List;
import java.util.Random;

/**
 * The default implementation of a {@link WordSearchGenerator}.
 */
public class DefaultWordSearchGenerator implements WordSearchGenerator {

    private final Grid grid;
    private final Configuration configuration;
    private final Random random;

    public DefaultWordSearchGenerator(Configuration configuration) {
        this.configuration = configuration;
        this.grid = new Grid(configuration.getGridSizeY(), configuration.getGridSizeX());
        this.random = new Random();
    }

    @Override
    public WordSearch generateWordSearch() throws WordSearchGenerationFailureException {

        for (String word : this.configuration.getWords()) {
            placeWord(word, null, 0);
        }

        fillGrid();

        return new WordSearch(
            this.grid.getGrid(),
            this.configuration.getWords()
        );
    }

    private void placeWord(String word, WordDirectionEnum direction, int level) throws WordSearchGenerationFailureException {
        if (direction == null) {
            direction = pickRandomDirection();
        }

        Coordinate startCoordinate = pickRandomStartCoordinate();

        if (validWordPosition(word, direction, startCoordinate)) {
            // Add the word to the grid.
            Coordinate coordinate = new Coordinate(startCoordinate.getX(), startCoordinate.getY());
            for (char c : word.toCharArray()) {
                this.grid.addCharAtCoordinate(c, coordinate);
                updateXandY(coordinate, direction);
            }
        } else if (level >= 500) {
            // Just stop after 500 fails.
            throw new WordSearchGenerationFailureException();
        } else if (level % 10 == 0) {
            // Try a new random direction every 10 fails.
            placeWord(word, null, ++level);
        } else {
            // New start coordinates are tried every time.
            placeWord(word, direction, ++level);
        }
    }

    private WordDirectionEnum pickRandomDirection() {
        List<WordDirectionEnum> directions = this.configuration.getDifficulty().getDirections();
        int randomIndex = this.random.nextInt(directions.size());
        return directions.get(randomIndex);
    }

    private Coordinate pickRandomStartCoordinate() {
        int randomX = this.random.nextInt(this.configuration.getGridSizeX());
        int randomY = this.random.nextInt(this.configuration.getGridSizeY());
        return new Coordinate(randomX, randomY);
    }

    private boolean validWordPosition(String word, WordDirectionEnum direction, Coordinate startCoordinate) {
        return wordSizeFits(word, direction, startCoordinate)
            && wordCharactersFit(word, direction, startCoordinate);
    }

    private boolean wordSizeFits(String word, WordDirectionEnum direction, Coordinate startCoordinate) {
        int freeSpace = 0;
        switch (direction) {
            case HORIZONTAL_RIGHT:
                freeSpace = this.configuration.getGridSizeX() - startCoordinate.getX();
                break;
            case HORIZONTAL_LEFT:
                freeSpace = (startCoordinate.getX() + 1);
                break;
            case VERTICAL_DOWN:
                freeSpace = this.configuration.getGridSizeY() - startCoordinate.getY();
                break;
            case VERTICAL_UP:
                freeSpace = (startCoordinate.getY() + 1);
                break;
            case DIAGONAL_RIGHT_DOWN:
                freeSpace = Math.min(
                    this.configuration.getGridSizeX() - startCoordinate.getX(),
                    this.configuration.getGridSizeY() - startCoordinate.getY()
                );
                break;
            case DIAGONAL_RIGHT_UP:
                freeSpace = Math.min(
                    this.configuration.getGridSizeX() - startCoordinate.getX(),
                    (startCoordinate.getY() + 1)
                );
                break;
            case DIAGONAL_LEFT_DOWN:
                freeSpace = Math.min(
                    (startCoordinate.getX() + 1),
                    this.configuration.getGridSizeY() - startCoordinate.getY()
                );
                break;
            case DIAGONAL_LEFT_UP:
                freeSpace = Math.min(
                    (startCoordinate.getX() + 1),
                    (startCoordinate.getY() + 1)
                );
                break;
        }
        return freeSpace >= word.length();
    }

    private boolean wordCharactersFit(String word, WordDirectionEnum direction, Coordinate startCoordinate) {
        Coordinate coordinate = new Coordinate(startCoordinate.getX(), startCoordinate.getY());
        for (char c : word.toCharArray()) {
            char currentChar = this.grid.getCharAtCoordinate(coordinate);
            if (currentChar != c && currentChar != 0) {
                return false;
            }
            updateXandY(coordinate, direction);
        }
        return true;
    }

    private void updateXandY(Coordinate coordinate, WordDirectionEnum direction) {
        switch (direction) {
            case HORIZONTAL_RIGHT:
                coordinate.incrementX();
                break;
            case HORIZONTAL_LEFT:
                coordinate.decrementX();
                break;
            case VERTICAL_DOWN:
                coordinate.incrementY();
                break;
            case VERTICAL_UP:
                coordinate.decrementY();
                break;
            case DIAGONAL_RIGHT_DOWN:
                coordinate.incrementX();
                coordinate.incrementY();
                break;
            case DIAGONAL_RIGHT_UP:
                coordinate.incrementX();
                coordinate.decrementY();
                break;
            case DIAGONAL_LEFT_DOWN:
                coordinate.decrementX();
                coordinate.incrementY();
                break;
            case DIAGONAL_LEFT_UP:
                coordinate.decrementX();
                coordinate.decrementY();
                break;
        }
    }

    private void fillGrid() {
        WordValidator validator = WordValidatorSingleton.getWordValidator();
        for (int y = 0; y < this.configuration.getGridSizeY(); y++) {
            for (int x = 0; x < this.configuration.getGridSizeX(); x++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (this.grid.getCharAtCoordinate(coordinate) == 0) {
                    this.grid.addCharAtCoordinate(validator.getRandomCharacter(), coordinate);
                }
            }
        }
    }
}
