.text
lui $4,0x0002
lui $3,0x0001
addi $1,$0,1
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
sb $1,1($3)
j inicio
led2:
sb $1,2($3)
j inicio
led3:
sb $1,3($3)
j inicio
