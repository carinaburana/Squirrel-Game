package util.ui.console;

public interface CommandTypeInfo {

    String getName();
    String getHelpText();
    Class<?> [] getParamTypes();

}
