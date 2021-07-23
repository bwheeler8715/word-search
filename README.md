# Word Search
This is a java project that generates a word-search from some user provided input. 

### Project Details
The project currently exports two jar files; word-search-core and word-search-generator. word-search-core contains the bulk of the code and defines everything necessary to create a word search.  word-search-generator defines the word search generator and the current main program. In the future a word-search-solver will be added to actually provide solutions to the word-searches that are generated.

### Running the Project
The project is a standard java / maven setup and can be run as such. For the time being it only takes a set of command line arguments that creates a configuration for the word-search. If none are provided then a default configuration is used.

#### Command Line Args
The command line args are as follows:

    [options] [difficulty] [gridSizeX] [gridSizeY] [word...]

##### Options
    -U, -USAGE: shows the usage message

##### Arguments
    difficulty: one of EASY, NORMAL, HARD, BRUTAL
    gridSizeX: size of the grid in the X direction
    gridSizeY: size of the grid in the Y direction
    word...: list of word to search for

##### Defaults when no arguments are provided
    difficulty: NORMAL
    gridSizeX: 15
    gridSizeY: 15
    word...: default list of computer terms
