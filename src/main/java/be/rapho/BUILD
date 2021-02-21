load("@rules_java//java:defs.bzl", "java_binary")

java_library(
    name = "InitialJavaClasses",
    visibility = ["//visibility:public"],
    srcs = glob([ "*.java" ] ),
)

java_binary(
    name = "QuickStartBin",
    main_class = "be.rapho.QuickStart",
    runtime_deps = [ ":InitialJavaClasses" ],
)
