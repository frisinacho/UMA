.text
lui $2,0x0001
addi $1,$0,1
nop
nop
nop
sw $1,0($2)
et: beq $0,$0,et
