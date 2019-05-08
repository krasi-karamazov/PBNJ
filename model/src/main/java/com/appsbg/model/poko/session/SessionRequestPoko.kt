package com.appsbg.model.poko.session

data class SessionRequestPoko(val method: String = "create_session_with_player_login_pub",
                              val id: String = "1",
                              val params: SessionParamsPoko)
