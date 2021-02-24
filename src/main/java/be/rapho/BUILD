load("@rules_java//java:defs.bzl", "java_binary")

java_library(
    name = "InitialJavaClasses",
    visibility = ["//visibility:public"],
    srcs = glob([ "**/*.java" ] ),
)

java_binary(
    name = "RotateGridBin",
    main_class = "be.rapho.RotateGrid",
    runtime_deps = [ ":InitialJavaClasses" ],
)
