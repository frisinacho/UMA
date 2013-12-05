.ktext 
sb $1,1($3)

.text
lui $4,0x0002
lui $3,0x0001
addi $1,$0,1
return:lb $5,1($4)
nop
nop
nop
beq $5,$1,nada
j return


nada:




