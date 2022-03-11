package com.example.addtwonumberbigger

class Utils {
    fun stringToListCharacter(str: String): ArrayList<Char> {
        val list: ArrayList<Char> = ArrayList()
        for (pos in 0 until str.length) {
            val currentCharacter = str[pos] //getting the character at current pos
            list.add(currentCharacter) //adding the character to the list
        }
        return list
    }

    fun completeLengthListCharacterByZero(list: ArrayList<Char>, positionsToComplete: Int) {
        //giant numbers are always considered otherwise use another method
        for (cantPositions in 0 until positionsToComplete) {
            list.add(0, '0')
        }
    }

}