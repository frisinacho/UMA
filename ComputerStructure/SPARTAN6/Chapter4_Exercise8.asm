.text
lui $3,0x0001
lui $4,0x0002
addi $1,$0,1
addi $17,$0,0x7FFF0000
comprobacion:lb $5,3($4)
nop
nop
nop
beq $5,$1, suma
j:comprobacion
suma:add $17,$17,$17

.ktext
sb $1,1($3)