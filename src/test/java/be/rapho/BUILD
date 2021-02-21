java_library(
    name = "tests",
    srcs = glob(["*.java"]),
    deps = [
        "//src/main/java/be/rapho:QuickStart",
        "@maven//:junit_junit",
    ],
    testonly = True,
)

java_test(
    name = "TestQuickStart",
    size = "small",
    runtime_deps = [
        ":tests",
        "//src/main/java/be/rapho:QuickStart",

    ],
    testonly = True,
)
