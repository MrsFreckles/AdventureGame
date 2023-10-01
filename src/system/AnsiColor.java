package system;

public enum AnsiColor {

    //Reset
    ANSI_RESET("\u001B[0m"),

    //Normal
    ANSI_BLACK("\u001B[30m"),
    ANSI_RED("\u001B[31m"),
    ANSI_GREEN("\u001B[32m"),
    ANSI_YELLOW("\u001B[33m"),
    ANSI_BLUE("\u001B[34m"),
    ANSI_PURPLE("\u001B[35m"),
    ANSI_CYAN("\u001B[36m"),
    ANSI_WHITE("\u001B[37m"),
    ANSI_ORANGE("\033[38;5;208m"),
    ANSI_GREY("\033[38;5;240m"),
    ANSI_LIGHT_GREY("\033[38;5;245m"),

    //Background
    ANSI_BLACK_BACKGROUND("\u001B[40m"),
    ANSI_RED_BACKGROUND("\u001B[41m"),
    ANSI_GREEN_BACKGROUND("\u001B[42m"),
    ANSI_YELLOW_BACKGROUND("\u001B[43m"),
    ANSI_BLUE_BACKGROUND("\u001B[44m"),
    ANSI_PURPLE_BACKGROUND("\u001B[45m"),
    ANSI_CYAN_BACKGROUND("\u001B[46m"),
    ANSI_WHITE_BACKGROUND("\u001B[47m"),

    //Underline
    ANSI_BLACK_UNDERLINE("\033[4;30m"),
    ANSI_RED_UNDERLINE("\033[4;31m"),
    ANSI_GREEN_UNDERLINE("\033[4;32m"),
    ANSI_YELLOW_UNDERLINE("\033[4;33m"),
    ANSI_BLUE_UNDERLINE("\033[4;34m"),
    ANSI_PURPLE_UNDERLINE("\033[4;35m"),
    ANSI_CYAN_UNDERLINE("\033[4;36m"),
    ANSI_WHITE_UNDERLINE("\033[4;37m"),

    //Bold
    ANSI_BLACK_BOLD("\033[1;30m"),
    ANSI_RED_BOLD("\033[1;31m"),
    ANSI_GREEN_BOLD("\033[1;32m"),
    ANSI_YELLOW_BOLD("\033[1;33m"),
    ANSI_BLUE_BOLD("\033[1;34m"),
    ANSI_MAGENTA_BOLD("\033[1;35m"),
    ANSI_CYAN_BOLD("\033[1;36m"),
    ANSI_WHITE_BOLD("\033[1;37m");

    private final String code;

    AnsiColor(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}

