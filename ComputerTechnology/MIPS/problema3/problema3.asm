.data
tamval: .word 4
tamdat: .word 15
datos: .word 2, 4, 2, 8, 2, 4, 2, 7, 5, 6, 5, 3, 7, 6, 8
valores: .word 2, 4, 6, 8
res: .word 0, 0, 0, 0

.text
main: 	
	addi $6, $0, 0 
	addi $9, $0, 0
	lw $7, tamval($0)
fun:	beq $7, $0, end
	addi $7, $7, -1
	sll $8, $9, 2
	lw $4, valores($8)
	addi $9, $9, 1
	jal hist
	sll $5, $6, 2
	sw $2, res($5)
	addi $6, $6, 1
	j fun

end:	li $2, 10
	syscall

hist:  	lw $11, tamdat($0)
	li $2, 0
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