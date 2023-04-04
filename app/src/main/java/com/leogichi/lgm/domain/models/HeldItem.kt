package com.leogichi.lgm.domain.models

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)