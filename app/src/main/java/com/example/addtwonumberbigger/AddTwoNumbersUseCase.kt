package com.example.addtwonumberbigger

import java.util.stream.Collectors

class AddTwoNumbersUseCase {

    var utils = Utils()

    fun sum(left: String, right: String): String? {
        //precond:
        //left and right not nulls
        // left and right Integers > 0
        // left is empty -> right
        // right is empty -> left
        // left and right “” -> “”

        val pattern = "[0-9]+"
        val messageError = "No podemos sumar"
        var hasRest = false

        if (!left.matches(Regex(pattern)) || !right.matches(Regex(pattern))) {
            return messageError
        } else if (left.isEmpty() && right.isEmpty()) {
            return ""
        } else if (left.isEmpty()) {
            return right
        } else if (right.isEmpty()) {
            return left
        }

        val leftList: ArrayList<Char> = utils.stringToListCharacter(left)
        val rightList: ArrayList<Char> = utils.stringToListCharacter(right)
        val resultList: ArrayList<Int> = ArrayList()
        if (left.length != right.length) {
            if (left.length > right.length) {
                utils.completeLengthListCharacterByZero(rightList, left.length - right.length)
            } else {
                utils.completeLengthListCharacterByZero(leftList, right.length - left.length)
            }
        }

        for (pos in leftList.size - 1 downTo 0) {
            var result: Int = if (hasRest) {
                Character.getNumericValue(leftList[pos]) + Character.getNumericValue(rightList[pos]) + 1
            } else {
                Character.getNumericValue(leftList[pos]) + Character.getNumericValue(rightList[pos])
            }
            if (result > 9) {
                hasRest = true
                resultList.add(0, result - 10)
            } else {
                hasRest = false
                resultList.add(0, result)
            }
        }
        return resultList.stream().map { obj: Any -> obj.toString() }.collect(Collectors.joining(""))
    }
}