package com.example.cleanWithCoRoutine.statistics.utils

import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError

class CustomStepper : Step {
    override fun onSelected() {}

    override fun verifyStep(): VerificationError? {
        return null
    }

    override fun onError(error: VerificationError) {}

}