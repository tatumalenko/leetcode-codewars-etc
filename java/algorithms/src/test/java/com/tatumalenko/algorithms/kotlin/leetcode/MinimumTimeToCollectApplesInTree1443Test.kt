package com.tatumalenko.algorithms.kotlin.leetcode

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

internal class MinimumTimeToCollectApplesInTree1443Test {

    @ParameterizedTest
    @MethodSource("minTimeProvider")
    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>, expected: Int) {
        assertEquals(expected, MinimumTimeToCollectApplesInTree1443.minTime(n, edges, hasApple))
    }

    @ParameterizedTest
    @MethodSource("reachedVerticesProvider")
    fun reachedVertices(vertexIndex: Int, edges: Array<IntArray>, expected: Set<Int>) {
        assertEquals(
            expected,
            MinimumTimeToCollectApplesInTree1443.reachedVertices(vertexIndex, edges)
        )
    }

    @ParameterizedTest
    @MethodSource("shouldKeepGoingProvider")
    fun shouldKeepGoing(vertexIndex: Int, edges: Array<IntArray>, hasApple: List<Boolean>, expected: Boolean) {
        assertEquals(expected, MinimumTimeToCollectApplesInTree1443.shouldKeepGoing(vertexIndex, edges, hasApple))
    }

    @Test
    fun shouldNotKeepGoing() {
        val hasApple = listOf(false, false, false, false, false, false, false)
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 4),
            intArrayOf(1, 5),
            intArrayOf(2, 3),
            intArrayOf(2, 6)
        )
        assertEquals(false, MinimumTimeToCollectApplesInTree1443.shouldKeepGoing(0, edges, hasApple))
    }

    companion object {
        @JvmStatic
        fun reachedVerticesProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(
                6,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                setOf<Int>()),
            Arguments.of(
                0,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                setOf(1, 2, 3, 4, 5, 6)),
            Arguments.of(
                1,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                setOf(4, 5)),
            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                setOf(3, 6)),
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                setOf<Int>()),
            Arguments.of(
                5,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                setOf<Int>()),
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                setOf<Int>()))

        @JvmStatic
        fun minTimeProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(
                4,
                arrayOf(
                    intArrayOf(0, 2),
                    intArrayOf(0, 3),
                    intArrayOf(1, 2)),
                listOf(false, true, false, false),
                4
            ),
            Arguments.of(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                listOf(false, false, true, false, true, true, false),
                8),
            Arguments.of(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                listOf(false, false, true, false, false, true, false),
                6),
            Arguments.of(
                7,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                listOf(false, false, false, false, false, false, false),
                0))

        //4
        //[[0,2],[0,3],[1,2]]
        //[false,true,false,false]

        @JvmStatic
        fun shouldKeepGoingProvider(): Stream<Arguments> = Stream.of(
            Arguments.of(
                3,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                listOf(false, false, true, false, true, true, false),
                false),
            Arguments.of(
                1,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                listOf(false, false, true, false, true, true, false),
                true),
            Arguments.of(
                0,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                listOf(false, false, true, false, true, true, false),
                true),

            Arguments.of(
                2,
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 2),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(2, 6)),
                listOf(false, false, true, false, true, true, false),
                true))
    }

}