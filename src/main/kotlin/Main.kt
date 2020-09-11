package ru.netology

import java.util.*

const val hundred = 100
const val minCommission = 3500
const val fee: Double = 0.75

fun main() {

    val scan = Scanner(System.`in`)
    println("Введите сумму текущего перевода в копейках")
    val amount = scan.nextLine().toInt()
    val commission = (amount * fee / hundred).toInt()
    val result = if (commission < minCommission) minCommission else commission
    println("Сумма текущего платежа в копейках $amount")
    println("Комиссия в копейках $result")
}


