import 'package:flutter/services.dart';

class MethodChannelPlugin {
  static const MethodChannel methodChannel =
      MethodChannel('com.apdbank.mb.personal');

  static Future<String> getOpt() async {
    try {
      return await methodChannel.invokeMethod('getOpt');
    } on PlatformException catch (e) {
      print(e);
      return '';
    }
  }
}
