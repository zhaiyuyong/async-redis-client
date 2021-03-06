package mobi.app.redis.netty.command;

import mobi.app.redis.transcoders.Transcoder;
import mobi.app.redis.transcoders.TranscoderUtils;

/**
 * User: thor
 * Date: 12-12-25
 * Time: 下午2:31
 */
public class RestoreCommand<T>  extends BaseCommand<T> {
    public RestoreCommand(Transcoder transcoder, String command, String key, int expire, byte[] v) {
        this.command = command;
        setTranscoder(transcoder);
        byte[][] byteArgs = new byte[3][];
        byteArgs[0] = TranscoderUtils.encodeString(key);
        byteArgs[1] = TranscoderUtils.encodeString(String.valueOf(expire));
        byteArgs[2] = v;
        init(byteArgs);
    }
}
