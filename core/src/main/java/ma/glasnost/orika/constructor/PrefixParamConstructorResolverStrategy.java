package ma.glasnost.orika.constructor;

import ma.glasnost.orika.impl.util.StringUtil;

import java.lang.reflect.Parameter;

/**
 * Finds constructor with param names that follow a prefix naming convention. For instance
 * p-prefixed param names - (pName, pAge).
 *
 */
public class PrefixParamConstructorResolverStrategy extends SimpleConstructorResolverStrategy {

    @Override
    protected String[] mapTargetParamNames(String[] parameters) {
        final String[] mappedParamNames = new String[parameters.length];
        for (int idx = 0; idx < parameters.length; idx++) {
            mappedParamNames[idx] = StringUtil.uncapitalize(parameters[idx].substring(1));
        }
        return mappedParamNames;
    }
}
