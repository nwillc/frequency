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

internal class SampleCollectionTest {

    @Test
    fun testAdd() {
        val frequency = Frequency<String>()
        val sampleCollection = SampleCollection<Int, String>(frequency)

        assertThat(sampleCollection.collection.size).isEqualTo(0)

        val wordList = "this is a test".wordList()
        val sample = Sample(1, wordList)
        sampleCollection.add(sample)

        assertThat(sampleCollection.collection.size).isEqualTo(1)
    }

    @Test
    internal fun testScore() {
        val frequency = Frequency<String>()
        val sampleCollection = SampleCollection<Int, String>(frequency)

        assertThat(sampleCollection.score(1)).isNull()

        val wordList = "this is a test".wordList()
        val sample = Sample(1, wordList)
        sampleCollection.add(sample)
        assertThat(sampleCollection.score(1)).isEqualTo(4)
    }

    @Test
    internal fun testRanked() {
        val frequency = Frequency<String>()
        val sampleCollection = SampleCollection<Int, String>(frequency)
        sampleCollection.add(Sample(1, "this is a test".wordList()))
        sampleCollection.add(Sample(2, "this is a test two".wordList()))

        val ranked = sampleCollection.ranked()
        assertThat(ranked.size).isEqualTo(2)
    }
}