package ru.netology

import java.util.*

const val hundred = 100
const val minCommission = 3500

var fee: Double = 0.0
var maxDay: Int = 0
var maxMonth: Int = 0
var amountNow = 0
var amountDay = 0
var amountMonth = 0

fun main() {

    val scan = Scanner(System.`in`)
    println("Введите сумму текущего перевода в рублях")
    amountNow = scan.nextLine().toInt()
    println("Введите сумму уже совершенных переводов за сегодняшний день в рублях")
    amountDay = scan.nextLine().toInt()
    println("Введите сумму уже совершенных переводов за текущий месяц в рублях")
    amountMonth = scan.nextLine().toInt()
    println("Введите '1' в случае перевода с КАРТЫ и любую другую цифру в случае перевода со счета VK Pay")
    val paymentType = scan.nextLine().toInt()

    if (paymentType == 1) {
        fee = 0.75
        maxDay = 15000000
        maxMonth = 60000000

        calk()

    } else {
        fee = 0.0
        maxDay = 1500000
        maxMonth = 4000000

        calk()
    }
}


fun calk() {
    val amount = amountNow * hundred
    val sumDay = amount + amountDay * hundred
    val sumMonth = amount + amountMonth * hundred
    if (sumDay > maxDay) {
        print("Перевод невозможен, превышен дневной лимит")
    } else if (sumMonth > maxMonth) {
        println("Перевод невозможен, превышен месячный лимит")
    } else {
        val commission = (amount * fee / hundred).toInt()
        val result = if (commission < minCommission && fee != 0.0) minCommission / hundred else commission / hundred
        println("Сумма текущего платежа в рублях $amountNow")
        println("Комиссия в рублях $result")
    }

}
