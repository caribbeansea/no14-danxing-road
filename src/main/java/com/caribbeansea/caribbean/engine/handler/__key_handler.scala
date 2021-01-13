package com.caribbeansea.caribbean.engine.handler

;

/* ************************************************************************
 *
 * Copyright (C) 2020 caribbeansea All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ************************************************************************/

/*
 * Creates on 2021/1/5.
 */

import com.caribbeansea.caribbean.engine.bootstrap.__panel
import engine.utils.Maps

import java.awt.event.{KeyEvent, KeyListener}

/**
 * @author tiansheng
 */
class __key_handler(panel: __panel) extends KeyListener {

  {
    panel.addKeyListener(this);
  }

  /**
   * 定义 java.util 下的Map
   */
  type map[K, V] = java.util.Map[K, V]

  /**
   * 目前支持的109个键
   */
  private val keymaps: map[Integer, __key] = newKeyMap(Array[Int](
    KeyEvent.VK_ENTER, KeyEvent.VK_BACK_SPACE, KeyEvent.VK_TAB, KeyEvent.VK_CANCEL,
    KeyEvent.VK_CLEAR, KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL, KeyEvent.VK_ALT,
    KeyEvent.VK_PAUSE, KeyEvent.VK_CAPS_LOCK, KeyEvent.VK_ESCAPE, KeyEvent.VK_SPACE,
    KeyEvent.VK_PAGE_UP, KeyEvent.VK_PAGE_DOWN, KeyEvent.VK_END, KeyEvent.VK_HOME,
    KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN,
    KeyEvent.VK_COMMA, KeyEvent.VK_MINUS, KeyEvent.VK_PERIOD, KeyEvent.VK_SLASH,
    KeyEvent.VK_0, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4,
    KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9,
    KeyEvent.VK_SEMICOLON, KeyEvent.VK_EQUALS, KeyEvent.VK_A, KeyEvent.VK_B,
    KeyEvent.VK_C, KeyEvent.VK_D, KeyEvent.VK_E, KeyEvent.VK_F, KeyEvent.VK_G,
    KeyEvent.VK_H, KeyEvent.VK_I, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L,
    KeyEvent.VK_M, KeyEvent.VK_N, KeyEvent.VK_O, KeyEvent.VK_P, KeyEvent.VK_Q,
    KeyEvent.VK_R, KeyEvent.VK_S, KeyEvent.VK_T, KeyEvent.VK_U, KeyEvent.VK_V,
    KeyEvent.VK_W, KeyEvent.VK_X, KeyEvent.VK_Y, KeyEvent.VK_Z, KeyEvent.VK_OPEN_BRACKET,
    KeyEvent.VK_BACK_SLASH, KeyEvent.VK_CLOSE_BRACKET, KeyEvent.VK_NUMPAD0,
    KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUMPAD4,
    KeyEvent.VK_NUMPAD5, KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUMPAD7, KeyEvent.VK_NUMPAD8,
    KeyEvent.VK_NUMPAD9, KeyEvent.VK_MULTIPLY, KeyEvent.VK_ADD, KeyEvent.VK_SEPARATER,
    KeyEvent.VK_SEPARATOR, KeyEvent.VK_SUBTRACT, KeyEvent.VK_DECIMAL, KeyEvent.VK_DIVIDE,
    KeyEvent.VK_DELETE, KeyEvent.VK_NUM_LOCK, KeyEvent.VK_SCROLL_LOCK, KeyEvent.VK_F1,
    KeyEvent.VK_F2, KeyEvent.VK_F3, KeyEvent.VK_F4, KeyEvent.VK_F5, KeyEvent.VK_F6,
    KeyEvent.VK_F7, KeyEvent.VK_F8, KeyEvent.VK_F9, KeyEvent.VK_F10, KeyEvent.VK_F11,
    KeyEvent.VK_F12, KeyEvent.VK_F13, KeyEvent.VK_F14, KeyEvent.VK_F15, KeyEvent.VK_F16,
    KeyEvent.VK_F17, KeyEvent.VK_F18, KeyEvent.VK_F19, KeyEvent.VK_F20, KeyEvent.VK_F21,
    KeyEvent.VK_F22, KeyEvent.VK_F23, KeyEvent.VK_F24, KeyEvent.VK_PRINTSCREEN, KeyEvent.VK_INSERT,
    KeyEvent.VK_HELP, KeyEvent.VK_META, KeyEvent.VK_BACK_QUOTE, KeyEvent.VK_QUOTE, KeyEvent.VK_KP_UP,
    KeyEvent.VK_KP_DOWN, KeyEvent.VK_KP_LEFT, KeyEvent.VK_KP_RIGHT, KeyEvent.VK_DEAD_GRAVE,
    KeyEvent.VK_DEAD_ACUTE, KeyEvent.VK_DEAD_CIRCUMFLEX, KeyEvent.VK_DEAD_TILDE, KeyEvent.VK_DEAD_MACRON,
    KeyEvent.VK_DEAD_BREVE, KeyEvent.VK_DEAD_ABOVEDOT, KeyEvent.VK_DEAD_DIAERESIS, KeyEvent.VK_DEAD_ABOVERING,
    KeyEvent.VK_DEAD_DOUBLEACUTE, KeyEvent.VK_DEAD_CARON, KeyEvent.VK_DEAD_CEDILLA, KeyEvent.VK_DEAD_OGONEK,
    KeyEvent.VK_DEAD_IOTA, KeyEvent.VK_DEAD_VOICED_SOUND, KeyEvent.VK_DEAD_SEMIVOICED_SOUND, KeyEvent.VK_AMPERSAND,
    KeyEvent.VK_ASTERISK, KeyEvent.VK_QUOTEDBL, KeyEvent.VK_LESS, KeyEvent.VK_GREATER, KeyEvent.VK_BRACELEFT,
    KeyEvent.VK_BRACERIGHT, KeyEvent.VK_AT, KeyEvent.VK_COLON, KeyEvent.VK_CIRCUMFLEX, KeyEvent.VK_DOLLAR,
    KeyEvent.VK_EURO_SIGN, KeyEvent.VK_EXCLAMATION_MARK, KeyEvent.VK_INVERTED_EXCLAMATION_MARK,
    KeyEvent.VK_LEFT_PARENTHESIS, KeyEvent.VK_NUMBER_SIGN, KeyEvent.VK_PLUS, KeyEvent.VK_RIGHT_PARENTHESIS,
    KeyEvent.VK_UNDERSCORE, KeyEvent.VK_WINDOWS, KeyEvent.VK_CONTEXT_MENU, KeyEvent.VK_FINAL, KeyEvent.VK_CONVERT,
    KeyEvent.VK_NONCONVERT, KeyEvent.VK_ACCEPT, KeyEvent.VK_MODECHANGE, KeyEvent.VK_KANA, KeyEvent.VK_KANJI,
    KeyEvent.VK_ALPHANUMERIC, KeyEvent.VK_KATAKANA, KeyEvent.VK_HIRAGANA, KeyEvent.VK_FULL_WIDTH, KeyEvent.VK_HALF_WIDTH,
    KeyEvent.VK_ROMAN_CHARACTERS, KeyEvent.VK_ALL_CANDIDATES, KeyEvent.VK_PREVIOUS_CANDIDATE, KeyEvent.VK_CODE_INPUT,
    KeyEvent.VK_JAPANESE_KATAKANA, KeyEvent.VK_JAPANESE_HIRAGANA, KeyEvent.VK_JAPANESE_ROMAN, KeyEvent.VK_KANA_LOCK,
    KeyEvent.VK_INPUT_METHOD_ON_OFF, KeyEvent.VK_CUT, KeyEvent.VK_COPY, KeyEvent.VK_PASTE, KeyEvent.VK_UNDO,
    KeyEvent.VK_AGAIN, KeyEvent.VK_FIND, KeyEvent.VK_PROPS, KeyEvent.VK_STOP, KeyEvent.VK_COMPOSE, KeyEvent.VK_ALT_GRAPH,
    KeyEvent.VK_BEGIN, KeyEvent.VK_UNDEFINED, KeyEvent.CHAR_UNDEFINED.toInt, KeyEvent.KEY_LOCATION_UNKNOWN,
    KeyEvent.KEY_LOCATION_STANDARD, KeyEvent.KEY_LOCATION_LEFT, KeyEvent.KEY_LOCATION_RIGHT, KeyEvent.KEY_LOCATION_NUMPAD
  ))

  private def newKeyMap(keycodes: Array[Int]): map[Integer, __key] = {
    val maps: map[Integer, __key] = Maps.newHashMap(keycodes.length)
    val key = new __key()
    for (keycode <- keycodes)
      maps.put(keycode, key.clone)

    maps /* return */
  }

  def toggle(e: KeyEvent, pressed: Boolean): Unit = {
    keymaps.get(e.getKeyCode).toggle(pressed)
  }

  /**
   * 判断某个键是否被按下
   *
   * @param keycode 键代码
   * @return 被按下return true，false反之
   */
  def down(keycode: Int): Boolean = keymaps.get(keycode).down

  override def keyTyped(e: KeyEvent): Unit = {
    /* do nothing */
  }

  override def keyPressed(e: KeyEvent): Unit = toggle(e, pressed = true)

  override def keyReleased(e: KeyEvent): Unit = toggle(e, pressed = false)

}
