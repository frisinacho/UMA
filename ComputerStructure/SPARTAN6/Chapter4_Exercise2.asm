.text
lui $4,0x0002
lui $3,0x0001
addi $1,$0,1
addi $7,$0,0
inicio:
lb $5,3($4)
nop
nop
nop
beq $5,$1,led1
lb $5,2,($4)
nop
nop
nop
beq $5,$1,led2
lb $5,1($4)
nop
nop
nop
beq $5,$1,led3
beq $0,$0,inicio

led1:
addi $7,$0,1
sb $1,1($3)
j mantener
led2:
addi $7,$0,2
sb $1,2($3)
j mantener
led3:
addi $7,$0,3
sb $1,3($3)
mantener:
add $8,$4,$7
nop
nop
nop
lb $5,0($8)
nop
nop
nop
bne $5,$0,mantener
add $8,$3,$7
nop
nop
nop
sb $0,0($8)
j inicio

