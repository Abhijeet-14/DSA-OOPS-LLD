# interface

- blueprint of class & class is blueprint of object
- only have method DECLARATIONS, No implementation
- All methods are abstract & public by default.

```
    public interface InterfaceDemo {
        static final String a = "Static Constant";
        
        // can't implement
        public void m1();
        
        // can't implement
        public void m2();
        
        static void m3() {
            // can implement
        }
                
        default int m4() {
            // can implement
            return 3;
        }
        
        private String m5() {
            // can implement
            return "Hello";
        
        }
    }
```
