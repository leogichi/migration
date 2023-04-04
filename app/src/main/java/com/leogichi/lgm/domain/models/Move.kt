package com.leogichi.lgm.domain.models

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)