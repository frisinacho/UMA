.data
tamdat: .word 15
datos: .word 2, 4, 2, 8, 2, 4, 2, 7, 5, 6, 5, 3, 7, 6, 8
res: .word 0

.text 
main:
li $4, 4
jal hist
sw $2, res($0)
li $2, 10
syscall

hist:  #(contar el número de veces que aparece el valor almacenado en $4 en el vector #datos y devolver el resultado en $2) 
	lw $11, tamdat($0)
	lw $2, res($0)
	addi $12, $0, 0
ini:	beq $11, $0, fin
	addi $11, $11, -1
	sll $14, $12, 2
	lw $13, datos($14)
	addi $12, $12, 1
	bne $4, $13, no
	addi $2, $2, 1
no:	j ini
fin:	jr $31