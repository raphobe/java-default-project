#! /bin/bash -xe

name="$1"

grep -R QuickStart src | cut -f1 -d':' | sort | uniq | xargs -I{} sh -c "sed -i 's/QuickStart/$name/g' {}"

git mv src/test/java/be/rapho/TestQuickStart.java src/test/java/be/rapho/Test$name.java
git mv src/main/java/be/rapho/QuickStart.java src/test/java/be/rapho/$name.java

