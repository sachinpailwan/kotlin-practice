package com.pailsom.kotlin

import kotlin.math.max

fun main() {
    val solution = LongestCommonSubsequence()
    val result = solution.longestCommonSubsequence("abcde","ace")
    print(result)
}
class LongestCommonSubsequence {

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val  n= text1.length
        val m = text2.length
        val dp = Array(n+1){ i->Array(m+1){ j->0} }
        for(i:Int in 1 until dp.size){
            for(j:Int in 1 until dp[0].size){
                if(text1.toCharArray()[i-1]==text2.toCharArray()[j-1]){
                    dp[i][j]=1+dp[i-1][j-1]
                }else{
                    dp[i][j]= max(dp[i-1][j],dp[i][j-1])
                }
            }
        }
        return dp[n][m]
    }
}