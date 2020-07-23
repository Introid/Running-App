package com.example.runningapp.repository

import com.example.runningapp.db.Run
import com.example.runningapp.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDAO: RunDAO
){
    suspend fun insertRun(run : Run) = runDAO.insertRun(run)
    suspend fun deleteRun(run : Run) = runDAO.deleteRun(run)

    fun getAllRunSortedByDate() = runDAO.getAllRunSortedByDates()
    fun getAllRunSortedByDistance() = runDAO.getAllRunSortedByDistance()
    fun getAllRunSortedByTimeInMillis() = runDAO.getAllRunSortedByTimeInMillis()
    fun getAllRunSortedByAvgSpeed() = runDAO.getAllRunSortedByAvgSpeed()
    fun getAllRunSortedByCaloriesBurned() = runDAO.getAllRunSortedByCaloriesBrned()
    fun getTotalAvgSpeed() = runDAO.getTotalAvgSpeed()
    fun getTotalDistance() = runDAO.getTotalDistance()
    fun getTotalCaloriesBurned() = runDAO.getTotalCaloriesBurned()
    fun getTotalTimeInMillis() = runDAO.getTotalTimeInMillis()

}