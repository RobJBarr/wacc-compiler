package compiler.Instructions

import CodeGen.Instructions.Instruction

class Store : Instruction {
    private val srcReg: Register
    private val dstAddress: Register
    private val offset: Int
    private val cond: Conditions?
    private val parameter: Boolean
    private val byte: Boolean

    constructor(srcReg: Register, dstAddress: Register, offset: Int, condition: Conditions? = null, parameter: Boolean = false, byte: Boolean = false) {
        this.srcReg = srcReg
        this.dstAddress = dstAddress
        this.offset = offset
        this.cond = condition
        this.parameter = parameter
        this.byte = byte
    }

    constructor(srcReg: Register, dstAddress: Register, condition: Conditions? = null, parameter: Boolean = false, byte: Boolean = false) {
        this.srcReg = srcReg
        this.dstAddress = dstAddress
        this.offset = 0
        this.cond = condition
        this.parameter = parameter
        this.byte = byte
    }

    override fun toString(): String {
        val output = StringBuilder()
        output.append("\tSTR")
        if (byte) output.append("B")
        if (cond != null) output.append(cond)
        output.append(" $srcReg, [$dstAddress")
        if (offset != 0) output.append(", #$offset")
        output.append("]")
        if (parameter) output.append("!")
        return output.toString()
    }
}