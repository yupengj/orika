package ma.glasnost.orika.metadata;

public enum MappingDirection {
    
    BIDIRECTIONAL {
        @Override
        MappingDirection flip() {
            return BIDIRECTIONAL;
        }

        @Override
        boolean includes(MappingDirection other) {
            return true;
        }
    },
    
    A_TO_B {
        @Override
        MappingDirection flip() {
            return B_TO_A;
        }

        @Override
        boolean includes(MappingDirection other) {
            return other != B_TO_A;
        }
    },
    
    B_TO_A {
        @Override
        MappingDirection flip() {
            return A_TO_B;
        }

        @Override
        boolean includes(MappingDirection other) {
            return other != A_TO_B;
        }
    };
    
    abstract MappingDirection flip();
    abstract boolean includes(MappingDirection other);
    
}
