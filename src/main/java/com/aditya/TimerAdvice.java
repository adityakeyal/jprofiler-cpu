package com.aditya;

import net.bytebuddy.asm.Advice;

public class TimerAdvice {

    @Advice.OnMethodEnter
    static long enter() {
        MyStatefulSingleton.getInstance().increment();
        return System.currentTimeMillis();
    }
    @Advice.OnMethodExit(onThrowable = Throwable.class)
    static void exit(@Advice.Origin("#t.#m") String method, @Advice.Enter long start) {
        final long l = System.currentTimeMillis() - start;
        /*if(l>0){
            System.out.println(MyStatefulSingleton.getInstance().get() + method + " took " + l);
        }*/

        MyStatefulSingleton.getInstance().add(method,l);
        MyStatefulSingleton.getInstance().decrement();
    }
}
