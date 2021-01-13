package engine.audio;

/* ************************************************************************
 *
 * Copyright (C) 2020 dahan All rights reserved.
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
 * Creates on 2020/12/30.
 */

/**
 * 支持所有格式的Audio对象
 *
 * AudioPlay有一个概念"与程序并行"。由于音频的播放是将文件解码后
 * 一帧一帧的进行播放，而这个播放的过程是阻塞性的，所以会导致整个程序被阻塞在
 * 音频播放上面。
 *
 * 对此我写了个类叫做{@link AbstractAudioPlay}，通过这个类去实现它的 {@link AbstractAudioPlay#run()}
 * 方法。实现并行运行。
 *
 * @author tiansheng
 */
public interface AudioPlay
{

    enum Play
    {
        ONCE, LOOP
    }

    /**
     * 播放音频, 这里的play如果没有特殊要求请不要重写它。
     * 因为它默认的作用是启动当前线程去播放音频。
     * <p>
     * 真正解码音频的是 {@link AbstractAudioPlay#run()} 方法，run()方法是继承自 {@link Thread}。
     * 所以如果要写解码音频格式的处理请在#run()中编写。
     *
     * @param play Play枚举代表当前播放的类型, {@link Play#ONCE}表示只播放一次。播放完毕后结束。
     *             而{@link Play#LOOP}表示循环播放，当播放完了之后又继续从头开始播放。
     */
    void play(Play play);

    /**
     * 播放一次
     */
    void once();

    /**
     * 循环播放
     */
    void loop();

    /**
     * 重新播放
     */
    void replay();

    /**
     * 暂停播放
     */
    void pause();

    /**
     * 继续播放，如果当前是暂停播放的状态
     */
    void continuePlay();

    /**
     * 当音乐播放完毕后执行该方法
     */
    void finish();

}
