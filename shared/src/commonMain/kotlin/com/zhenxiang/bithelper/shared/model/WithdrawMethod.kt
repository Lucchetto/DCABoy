package com.zhenxiang.bithelper.shared.model

import com.ionspin.kotlin.bignum.decimal.BigDecimal

data class WithdrawMethod(
    val name: String,
    val exchangeInternalId: String,
    val description: String?,
    val available: Boolean,
    val fee: BigDecimal?,
    val memoRequired: Boolean?,
)