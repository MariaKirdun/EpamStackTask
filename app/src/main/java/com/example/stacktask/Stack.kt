package com.example.stacktask

class Stack<T> {

    private val DEFAULT_SIZE = 10

    private var peekIndex = -1

    private var array : Array<T?>

    init {
        array = arrayOfNulls<Any?>(DEFAULT_SIZE) as Array<T?>
    }

    fun pop() : T? {
        if (peekIndex >= 0) {
        val element = array[peekIndex]
        array[peekIndex] = null
        peekIndex--
        return element
        }
        throw EmptyStackExeption("Empty stack")
    }

    fun push(data : T){
        if (peekIndex + 1 == array.size) {
            val newSize = (array.size * 1.5).toInt()
            array = array.copyOf(newSize)
        }
        peekIndex++
        array[peekIndex] = data
    }

    fun peek() : T? {
        return array.last()
    }

    override fun toString(): String {
        return array.joinToString()
    }

}