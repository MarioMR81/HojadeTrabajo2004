import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    
    public static void main(String[] args) {
        // Ejemplo de código fuente en Java
        String javaCode = 
                "int z = 5;\n" +
                "double pi = 3.14;\n" +
                "String message = \"Hola, mundo!\";\n";
        
        // Analizar el código fuente y extraer las declaraciones de variables
        String[] declarations = parseJava(javaCode);
        
        // Mostrar las declaraciones de variables encontradas
        for (String declaration : declarations) {
            System.out.println(declaration);
        }
    }
    
    // Función para analizar el código fuente y extraer las declaraciones de variables
    public static String[] parseJava(String code) {
        // Patrón para identificar declaraciones de variables en Java
        String declarationPattern = "\\b(int|double|float|char|String)\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*=\\s*([^;]*)";
        
        // Compilar el patrón de expresión regular
        Pattern pattern = Pattern.compile(declarationPattern);
        
        // Se aplico un Matcher
        Matcher matcher = pattern.matcher(code);
        
        // se enlisto para almacenar las declaraciones
        StringBuilder variableDeclarations = new StringBuilder();
        
        // Encontrar todas las coincidencias de declaraciones
        while (matcher.find()) {
            String dataType = matcher.group(1);
            String variableName = matcher.group(2);
            String variableValue = matcher.group(3);
            String declaration = "Tipo de dato: " + dataType + ", Nombre de la variable: " + variableName + ", Valor: " + variableValue;
            variableDeclarations.append(declaration).append("\n");
        }
        
        // Devolver las declaraciones de variables
        return variableDeclarations.toString().split("\n");
    }
}