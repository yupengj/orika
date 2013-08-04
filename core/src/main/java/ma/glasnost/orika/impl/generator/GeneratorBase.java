package ma.glasnost.orika.impl.generator;

import ma.glasnost.orika.metadata.FieldMap;

public abstract class GeneratorBase {
    /**
     * Generates a comment marking the beginning of code for mapping the specified field
     * 
     * @param out the source code output
     * @param fieldMap the FieldMap for which code is generated
     * @param code the current context
     */
    protected void beginMappingField(StringBuilder out, FieldMap fieldMap, SourceCodeContext code) {
        if (code.writesSourceFiles()) {
            out.append("\n/* -------------- BEGIN --| " + fieldMap.getSourceExpression() + " => " + 
                    fieldMap.getDestinationExpression() + " -- */\n");
        }
    }
    
    /**
     * Generates a comment marking the end of code for mapping the specified field
     * 
     * @param out the source code output
     * @param fieldMap the FieldMap for which code is generated
     * @param code the current context
     */
    protected void endMappingField(StringBuilder out, FieldMap fieldMap, SourceCodeContext code) {
        if (code.writesSourceFiles()) {
            out.append("\n/* -------------- END ----| " + fieldMap.getSourceExpression() + " => " + 
                    fieldMap.getDestinationExpression() + " -- */\n");
        }
    }
}
