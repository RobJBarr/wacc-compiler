package compiler.Instructions

import CodeGen.Instructions.Instruction
import java.lang.StringBuilder

class Pop(private val registers: List<Register>, private val cond: Conditions? = null) : Instruction {

    override fun toString(): String {
        val instr = StringBuilder()
        instr.append("\tPOP")
        if (cond != null) instr.append(cond)
        instr.append(" {${registers.joinToString(separator = ",")}}")
        return instr.toString()
    }
}