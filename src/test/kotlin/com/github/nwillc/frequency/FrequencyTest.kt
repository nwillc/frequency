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

internal class FrequencyTest {
    @Test
    internal fun testFrequencyNoScore() {
        val frequency = Frequency<String>()

        assertThat(frequency.get("FOO")).isEqualTo(0)
    }

    @Test
    internal fun testFrequencyOneScore() {
        val frequency = Frequency<String>()

        frequency.increment("FOO")
        assertThat(frequency.get("FOO")).isEqualTo(1)
    }

    @Test
    internal fun testFrequencyAddOneScore() {
        val frequency = Frequency<String>()

        frequency.increment("FOO")
        frequency.increment("FOO")
        assertThat(frequency.get("FOO")).isEqualTo(2)
    }
}