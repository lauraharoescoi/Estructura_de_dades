package factorial;

import stack.LinkedStack;

public class Factorial {
    private static class Context {
        int n;
        int f;
        EntryPoint entryPoint;

        Context(int n) {
            this.n = n;
            this.f = 0;
            this.entryPoint = EntryPoint.CALL;
        }
    }

    public static int factorialRec(int n) {
        int f = 0;
        // CALL
        if (n == 0) return 1;
        else {
            f = factorialRec(n - 1); // recurse
            // RESUME
            return n * f;
        }
    }

    public static int factorialIter(int n) {
        int return_ = 0;
        var stack = new LinkedStack<Context>();
        stack.push(new Context(n));
        while (!stack.isEmpty()) {
            var context = stack.top();
            switch (context.entryPoint) {
                case CALL -> {
                    if (context.n == 0) {
                        return_ = 1;
                        stack.pop();
                    } else {
                        context.entryPoint = EntryPoint.RESUME;
                        stack.push(new Context(context.n - 1));
                    }
                }
                case RESUME -> {
                    context.f = return_;
                    return_ = context.f * context.n;
                    stack.pop();
                }
            }
        }
        return return_;
    }
}
