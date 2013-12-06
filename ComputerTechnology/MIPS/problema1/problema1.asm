.data
tam: .word 14
datos: .word 2, 4, 2, 8, -2, 4, 2, -7, 8, 43, -5, -45, 3, 4
min: .word 0

.text
main:	lw $11, tam($0)
	lw $12, min($0)
	addi $13, $0, 0
	
ini:	beq $11, $0, fin
	addi $11, $11, -1
	sll $15, $13, 2
	lw $14, datos($15)
	addi $13, $13, 1
	ble $12, $14, no
	addi $12, $14, 0
no:	j ini

fin:	sw $12, min($0)

	li $20, 10
	syscall