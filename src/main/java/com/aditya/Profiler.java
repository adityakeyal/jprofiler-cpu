package com.aditya;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;
import java.util.Arrays;

public class Profiler {

    public static void premain(String argument, Instrumentation instrumentation) {



        // find class files
        new AgentBuilder.Default()
                .ignore(ElementMatchers.nameStartsWith("net.bytebuddy."))
                .ignore(ElementMatchers.nameStartsWith("org."))
                .type(typeDefinitions -> match(typeDefinitions.getCanonicalName(),argument))
                .transform( (builder, type, classLoader, module, protectionDomain) -> builder.visit(Advice.to(TimerAdvice.class).on( ElementMatchers.isMethod())))
//                .transform( (builder, type, classLoader, module, protectionDomain) -> builder.method(ElementMatchers.isPublic()).intercept(
//                        MethodDelegation.to(TimerAdvice.class)
//                ))

                .installOn(instrumentation);

    }

    private static boolean match(String canonicalName, String argument) {
        final String[] packageNames = argument.split(",");
        return Arrays.stream(packageNames).anyMatch(canonicalName::startsWith);
    }


}
