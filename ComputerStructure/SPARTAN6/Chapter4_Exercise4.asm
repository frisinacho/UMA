.text
lui $2,0x0001
addi $1,$0,1
addi $4, $0,0
lui $3,0x0065
nop
nop
nop
#ori $3,$7,0xb9aa
nop
nop
nop
lui $5,0x0032
nop
nop
nop
#ori $5,$7,0xdcd5

salto:
sb $1,2($2)
addi $4,$4,1
nop
nop
nop
bne $4,$3,salto
addiu $4,$0,0
nop
nop
nop
addi $4,$0,0
bne $4,$0,salto
sb $0,2($2)
rs:
addi $4,$4,1
nop
nop
nop
bne $4,$5,rs
addi $4,$0,0
j salto

