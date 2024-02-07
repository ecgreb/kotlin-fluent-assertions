# Kotlin Fluent Assertions

Simple (work in progress) demo app to compare assertion libraries on Kotlin and Android (coming soon)

#### Evaluation currently includes

* [JUnit4](https://junit.org/junit4/) ([source](https://github.com/junit-team/junit4)) - the classic
* [Truth](https://truth.dev/) ([source](https://github.com/google/truth)) - Google's fluent assertion framework
* [AssertK](https://www.willowtreeapps.com/craft/fluent-assertions-in-kotlin-using-assertk) ([source](https://github.com/willowtreeapps/assertk)) - Kotlin assertions inspired by AssertJ

#### Other Kotlin assertion frameworks

* [JUnit5](https://junit.org/junit5/) ([source](https://github.com/junit-team/junit5)) - not yet supported on Android*
* [Hamcrest](https://hamcrest.org/) ([source](https://github.com/hamcrest)) - matchers ex. `assertThat(theBiscuit, equalTo(myBiscuit))`
* [AssertJ](https://joel-costigliola.github.io/assertj/) ([source](https://github.com/assertj/assertj)) - the original fluent assertions for Java
* [kotlin.test](https://kotlinlang.org/api/latest/kotlin.test/) ([source](https://github.com/JetBrains/kotlin)) - Kotlin's built-in assertions
* [Strikt](https://strikt.io/) ([source](https://github.com/robfletcher/strikt)) - lambdas and extension functions
* [Kluent](https://markusamshove.github.io/Kluent/)) ([source](https://github.com/MarkusAmshove/Kluent)) - infix notation ex. `"hello" shouldBeEqualTo "hello"`
* [Atrium](https://docs.atriumlib.org/) ([source](https://github.com/robstoll/atrium)) - mutliplatform support
* [Expekt](https://winterbe.github.io/expekt/) ([source](https://github.com/winterbe/expekt)) - BDD style assertions ex. `23.should.equal(23)`
* [HamKrest](https://github.com/npryce/hamkrest/tree/jvm/docs) ([source](https://github.com/npryce/hamkrest)) - Kotlin matchers `assertThat("xyz", startsWith("x") and !containsSubstring("a"))`
* [Kotest](https://kotest.io/) ([source](https://github.com/kotest/kotest)) - popular (4k+ stars) assertions and full test framework with multiplatform support

\* [open source Gradle plugin](https://github.com/mannodermaus/android-junit5) for running JUnit5 tests on Android
