package com.camc.tvcanal

import android.app.Application
import com.camc.tvcanal.Repository.TVRepository
import com.camc.tvcanal.data.canal

class TVReviewerApplication: Application(){
    val canalRepository: TVRepository by lazy{
        TVRepository(canal)
    }
}
