package com.example.guidedstepsupportfragmentissue

import android.os.Bundle
import androidx.leanback.app.GuidedStepSupportFragment
import androidx.leanback.widget.GuidanceStylist.Guidance
import androidx.leanback.widget.GuidedAction
import androidx.leanback.widget.GuidedAction.Builder


class MyOnboardingFragment : GuidedStepSupportFragment() {
    companion object {
        var NEXT_STEP: Long = 100001
    }

    override fun onCreateGuidance(savedInstanceState: Bundle?): Guidance {
        return Guidance(
            "Test 1",
            "Description 1",
            "Breadcrumb 1",
            activity?.getDrawable(android.R.drawable.ic_menu_revert)
        )
    }

    override fun onCreateActions(actions: MutableList<GuidedAction>, savedInstanceState: Bundle?) {
        super.onCreateActions(actions, savedInstanceState)

        actions.add(
            Builder(context)
                .id(NEXT_STEP)
                .title("Next step")
                .description("Next description")
                .hasNext(true)
                .build()
        )
    }

    override fun onGuidedActionClicked(action: GuidedAction) {
        val fm = parentFragmentManager
        when(action.id) {
            NEXT_STEP -> add(fm, NextStepFragment())
        }
    }
}

class NextStepFragment : GuidedStepSupportFragment() {
    override fun onCreateGuidance(savedInstanceState: Bundle?): Guidance {
        return Guidance(
            "Step 2",
            "Description 2",
            "Breadcrumb 2",
            requireActivity().getDrawable(android.R.drawable.ic_menu_agenda)
        )
    }
}
