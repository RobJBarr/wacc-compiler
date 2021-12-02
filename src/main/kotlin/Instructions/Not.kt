package compiler.Instructions

import CodeGen.Instructions.Instruction

class Not(private val dst: Register, private val src: Register) : Instruction {
    override fun toString(): String {
      return ("\tEOR $dst, $src, #1")
    }
}