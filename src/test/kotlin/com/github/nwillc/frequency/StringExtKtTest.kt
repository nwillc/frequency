/*
 * Copyright 2019 nwillc@gmail.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any purpose with or without fee is hereby granted, provided that the above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.github.nwillc.frequency

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringExtKtTest {
    @Test
    fun testSimpleWord() {
        assertThat("Foo".wordList()).containsExactly("foo")
        assertThat("Foo pigs".wordList()).containsExactly("foo", "pigs")
    }

    @Test
    fun testOddWord() {
        assertThat("Foo 4".wordList()).containsExactly("foo")
        assertThat("Foo: 4 pigs".wordList()).containsExactly("foo", "pigs")
        assertThat("[ Foo: 4,  pigs: 6 }".wordList()).containsExactly("foo", "pigs")
    }

    @Test
    fun testPunctuatedWord() {
        assertThat("Foo's".wordList()).containsExactly("foo's")
        assertThat("Foo's time-Share".wordList()).containsExactly("foo's", "time-share")
    }

    @Test
    fun testPunctuatedWordRepeated() {
        assertThat("Foo foo".wordList()).containsExactly("foo", "foo")
    }
}