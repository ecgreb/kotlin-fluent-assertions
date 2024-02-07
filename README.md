# Kotlin Fluent Assertions

Simple (work in progress) demo app to compare assertion libraries on Kotlin and Android (coming soon)

#### Evaluation currently includes

* [JUnit4]([url](https://junit.org/junit4/)) ([source]([url](https://github.com/junit-team/junit4))) - the classic
* [Truth]([url](https://truth.dev/)) ([source]([url](https://github.com/google/truth))) - Google's fluent assertion framework
* [AssertK]([url](https://www.willowtreeapps.com/craft/fluent-assertions-in-kotlin-using-assertk)) ([source]([url](https://github.com/willowtreeapps/assertk))) - Kotlin assertions inspired by AssertJ

#### Other Kotlin assertion frameworks

* [JUnit5]([url](https://junit.org/junit5/)) ([source]([url](https://github.com/junit-team/junit5))) - not yet supported on Android*
* [Hamcrest]([url](https://hamcrest.org/)) ([source]([url](https://github.com/hamcrest))) - matchers ex. `assertThat(theBiscuit, equalTo(myBiscuit))`
* [AssertJ]([url](https://joel-costigliola.github.io/assertj/)) ([source]([url](https://github.com/assertj/assertj))) - the original fluent assertions for Java
* [kotlin.test]([url](https://kotlinlang.org/api/latest/kotlin.test/)) ([source]([url](https://github.com/JetBrains/kotlin))) - Kotlin's built-in assertions
* [Strikt]([url](https://strikt.io/)) ([source]([url](https://github.com/robfletcher/strikt))) - lambdas and extension functions
* [Kluent]([url](https://markusamshove.github.io/Kluent/)) ([source]([url](https://github.com/MarkusAmshove/Kluent))) - infix notation ex. `"hello" shouldBeEqualTo "hello"`
* [Atrium]([url](https://docs.atriumlib.org/)) ([source]([url](https://github.com/robstoll/atrium))) - mutliplatform support
* [Expekt]([url](https://winterbe.github.io/expekt/)) ([source]([url](https://github.com/winterbe/expekt))) - BDD style assertions ex. `23.should.equal(23)`
* [HamKrest]([url](https://github.com/npryce/hamkrest/tree/jvm/docs)) ([source]([url](https://github.com/npryce/hamkrest)https://github.com/npryce/hamkrest)) - Kotlin matchers `assertThat("xyz", startsWith("x") and !containsSubstring("a"))`
* [Kotest]([url](https://kotest.io/)https://kotest.io/) ([source]([url](https://github.com/kotest/kotest)https://github.com/kotest/kotest)) - popular (4k+ stars) assertions and full test framework with multiplatform support

\* [open source Gradle plugin](https://github.com/mannodermaus/android-junit5) for running JUnit5 tests on Android
