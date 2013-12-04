.text
lui $4,0x0002
lui $3,0x0001
addi $1,$0,1
nop
et:
lw $5,0($4)
nop
nop
nop
bne $5,$1,et
sw $1,3($3)
fun:
lw $5,0($4)
beq $5,$1,fun
sw $0,3($3)
j et
