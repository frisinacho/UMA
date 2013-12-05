.text
lui $4,0x0002
lui $3,0x0001
addi $1,$0,1
inicio:
lb $5,0($4)
nop
nop
nop
andi  $6,$5,1
nop
nop
nop
beq $6,$0,nouno
sb $1,3($3)
j uno
nouno:
sb $0,3($3)
uno:
andi $6,$5,2
nop
nop
nop
beq $6,$0,nodos
sb $1,2($3)
j dos
nodos:
sb $0,2($3)
dos:
andi $6,$5,4
nop
nop
nop
beq $6,$0,notres
sb $1,1($3)
j tres
notres:
sb $0,1($3)
tres:
andi $6,$5,8
nop
nop
nop
beq $6,$0,nocuatro
sb $1,0($3)
j inicio
nocuatro:
sb $0,0($3)
j inicio

